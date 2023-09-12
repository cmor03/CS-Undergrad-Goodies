public class Cache implements ReadOnlyCache {
	private Memory m_memory;

	private boolean[] valid;
	// number of blocks

	private int[] tag;
	// number of blocks

	private byte[][] data;
	// number of blocks * number of bytes per block

	private int offSet;
	// index the offset begins

	private int index;
	// number of bits in the offset

	private int blockCount;
	// stores number of blocks

	private int bytesPerBlock;

	public Cache(Memory memory, int blockCount, int bytesPerBlock, int associativity) {
		
		//initialization of all variables
		m_memory = memory;
		valid = new boolean[blockCount];
		tag = new int[blockCount];
		data = new byte[blockCount][bytesPerBlock];
		this.bytesPerBlock = bytesPerBlock;
		this.blockCount = blockCount;

	}


	public byte load(int address) {

		int indexAddress = index(address);
		
		//if the index is valid and the tag at the location equals the address
		if (valid[indexAddress] && tag[indexAddress] == tag(address)) {
			return data[indexAddress][offset(address)];
		}
		
		//if the index isn't valid, and the tag doesn't equal the address
		if (!valid[indexAddress] || tag[indexAddress] != tag(address)) {

			
			valid[indexAddress] = true;
			tag[indexAddress] = tag(address);
			int getBlock = blockAddress(address);

			data[indexAddress] = m_memory.read(getBlock, bytesPerBlock);
			return data[indexAddress][offset(address)];
		}
		return m_memory.read(address, 1)[0];

	}

	//calculates the index location
	public int index(int address) {

		int index = (address / bytesPerBlock) % blockCount;
		return index;

	}
	
	//calculates the tag
	public int tag(int address) {
		index = (address / bytesPerBlock);
		index /= blockCount;
		return index;

	}
	
	//calculates the offset
	public int offset(int address) {
		offSet = address % bytesPerBlock;
		return offSet;
	}

	//calculates the final offset, AKA the actual location
	public int blockAddress(int address) {
		int blockAddress = address - offset(address);
		return blockAddress;

	}

}
