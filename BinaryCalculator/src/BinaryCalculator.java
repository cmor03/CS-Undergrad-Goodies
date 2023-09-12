/**
 * Class with methods to implement the basic arithmetic operations by operating
 * on bit fields.
 *
 * This is the skeleton code for COMP2691 Assignment #2.
 */
public class BinaryCalculator {
	public static BitField add(BitField a, BitField b) {

		/**
		 * @returns the binary value of sum of Bitfield A and Bitfield B
		 * @throws IllegalArgumentException if one of the parameters is null, or if the
		 *                                  parameters aren't the same size
		 */

		if (null == a || null == b || a.size() != b.size()) {
			throw new IllegalArgumentException(
					"BinaryCalculator.add(a,b): a and b cannot be null and must be the same length.");

		} else {

			// this method will recursively call itself until completion
			addBit(a, b, a.size() - 1, false, 0);
		}

		return a;
	}

	/**
	 * This method will continuously call itself, performing addition on each of the
	 * bits in the corresponding index location until it reaches the end of the bit
	 * sequence
	 *
	 * @param a        represents BitField a (the one being changed, or added to
	 * @param b        represents what is being added to a
	 * @param size     is the size of the binary sequence that is being actively
	 *                 added
	 * @param carryBit is the single binary bit that is used if the prior sequence
	 *                 had leftover bits, hence carryBits
	 * @return returns the carryBit for the current bit addition
	 * 
	 */

	public static void addBit(BitField a, BitField b, int size, Boolean carryBit, int index) {

		// we start by setting our current carryBit to false
		boolean carryBitOut = false;

		// because this is a recursive method, we have a base case of index <= size
		if (index <= size) {

			// case one is for if both bits are true
			if (a.get(index) == true && b.get(index) == true) {

				a.set(index, false);

				if (carryBit) {
					a.set(index, true);
				}
				carryBitOut = true;

				// case two if for if one of the bits is true
			} else if (a.get(index) == true || b.get(index) == true) {
				a.set(index, true);

				if (carryBit) {
					a.set(index, false);
					carryBitOut = true;
				}

				// case three is for if all bits are false, but the carryBit is true
			} else if (carryBit) {
				a.set(index, true);
			}

			addBit(a, b, size, carryBitOut, index + 1);
		}

	}

	/**
	 * Subtract will subtract BitField b from Bitfield a
	 * 
	 * @param a is BitField a (the minuend)
	 * @param b is BitField b (the subtrahend)
	 * @return returns BitField a, that has been changed "in place" I chose to
	 *         change a in place, as oppose to changing a new variable at the
	 *         corresponding index location, save space
	 */

	public static BitField subtract(BitField a, BitField b) {
		if (null == a || null == b || a.size() != b.size()) {
			throw new IllegalArgumentException(
					"BinaryCalculator.add(a,b): a and b cannot be null and must be the same length.");

		} else {
			subBit(a, b, a.size() - 1, 0);
		}

		return a;
	}

	/**
	 * 
	 * @param a     is BitField a (the minuend)
	 * @param b     is BitField b (the subtrahend)
	 * @param size  the size of BitField a
	 * @param index the current index location of the bit that is being altered.
	 *              When this recursive method is just called, this index location
	 *              is 0.
	 */
	public static void subBit(BitField a, BitField b, int size, int index) {

		// this is our base case. The method will stop calling itself if we are out of
		// bounds
		if (index <= size) {
			// this is our case for if both of the bits are true
			if (a.get(index) == true && b.get(index) == true) {
				a.set(index, false);
				// this is our case for if our a bit is false, and our b bit is true
			} else if (a.get(index) == false && b.get(index) == true) {

				// i is declared outside of its for loop because we need to use it outside of
				// the loop
				int i;

				// this loop is used to search through the bit sequence to find a "donor bit"
				// that we can take from to perform our subtraction
				for (i = index; a.get(i) != true; i++) {

					// this is just a base case to make sure that if we're at the end of our loop
					// we don't keep going
					if (i == size) {
						i = size;
						break;
					}
				}
				if (a.get(i) == true) {
					a.set(i, false);
				} else {
					a.set(i, true);
				}

				for (int j = index; j < i; j++) {
					a.set(j, true);
				}
			}

			subBit(a, b, size, index + 1);
		}

	}

	public static BitField multiply(BitField a, BitField b) {

		if (null == a || null == b || a.size() != b.size()) {
			throw new IllegalArgumentException(
					"BinaryCalculator.add(a,b): a and b cannot be null and must be the same length.");

		}

		if (a.equals(new BitField(a.size())) || b.equals(new BitField(a.size()))) {
			return new BitField(b.size());
		}
		
		
		BitField runningSum = new BitField(a.size());
		BitField totalSum = runningSum.copy();

		// what I've done here is tricky-- I used a double loop and logic to multiply
		// each of the b term factors by the entire a term, and then I added the answer
		// to the total answer
		for (int i = 0; i < a.size(); i++) {
			for (int j = 0; j < a.size(); j++) {

				if (a.get(j) == true && b.get(i) == true) {
					// j + i is where I add the bottom location to the i location, moving across the
					// cursor "head"
					if ((j + i) < a.size()) {
						runningSum.set(j + i, true);
					}
				}
			}

			// leftShiftOne(runningSum, i);
			add(totalSum, runningSum);
			runningSum.setAll(false);
		}
		return totalSum;
	}

	public static BitField[] divide(BitField a, BitField b) {
		if (null == a || null == b || a.size() != b.size()) {
			throw new IllegalArgumentException(
					"BinaryCalculator.add(a,b): a and b cannot be null and must be the same length.");
		}

		if (b.equals(new BitField(a.size()))) {
			return null;
		}

		// Return both the quotient and the remainder
		BitField[] out = new BitField[2];
		out[0] = new BitField(a.size()); // quotient
		out[1] = new BitField(a.size()); // remainder

		BitField quotient = new BitField(a.size() * 2);
		BitField remainder = new BitField(a.size() * 2);
		BitField divisor = new BitField(a.size() * 2);

		BitField aCopy = null;
		BitField bCopy = null;

		boolean remainderFlag = false;
		boolean quotientFlag = false;

		// the next sequence of if statements takes the absolute value of the bit
		// sequences and marks them as flipped if done so
		if (a.getMSB()) {
			aCopy = flipSign(a);
			remainderFlag = true;
		} else {
			aCopy = a.copy();
		}
		if (b.getMSB()) {
			bCopy = flipSign(b);
		} else {
			bCopy = b.copy();
		}

		// sets the lower bits of the size doubled divisor and remainder
		for (int i = 0; i < b.size(); i++) {
			divisor.set(i, bCopy.get(i));
		}
		for (int i = 0; i < b.size(); i++) {
			remainder.set(i, aCopy.get(i));
		}

		if (a.getMSB() != b.getMSB()) {
			quotientFlag = true;
		}

		for (int i = 0; i < aCopy.size(); i++) {
			divisor = leftShift(divisor);
		}

		for (int i = 0; i <= a.size(); i++) {
			// subtract the divisor from the remainder register and place the result in the
			// remainder register
			remainder = subtract(remainder, divisor);
			// is the remainder > or < 0

			// >= shift the quotient register to the left, setting the new rightmost bit to
			// 1
			if (!remainder.getMSB()) {
				quotient = leftShift(quotient);
				quotient.set(0, true);
			} else {
				// <0 restore the register to the original value by adding the divisor register
				// to the remainder register and placing the sum in the remainder register. Also
				// shift the quotient register to the left, setting the new LSB to 0
				remainder = add(remainder, divisor);
				quotient = leftShift(quotient);
				quotient.set(0, false);
			}

			// shift the divisor register right 1 bit
			divisor = rightShift(divisor);
		}

		// repeat until at the end of the bit sequence

		// flips the sign if the marker was turned on at the beginning of the method
		if (remainderFlag) {
			remainder = flipSign(remainder);
		}
		if (quotientFlag) {
			quotient = flipSign(quotient);
		}

		out[0] = halfBits(quotient);
		out[1] = halfBits(remainder);

		return out;

	}

	// written in class
	public static BitField flipSign(BitField a) {
		BitField temp = complement(a);
		BitField one = new BitField(a.size());
		one.set(0, true);

		return add(temp, one);
	}

	// written in class
	public static BitField complement(BitField a) {
		BitField out = new BitField(a.size());
		for (int i = 0; i < a.size(); i++) {
			out.set(i, !a.get(i));
		}
		return out;
	}

	// written in class
	public static BitField rightShift(BitField a) {
		BitField b = a.copy();

		for (int i = 1; i < b.size(); i++) {
			a.set(i - 1, b.get(i));
		}
		a.set(a.size() - 1, false);
		return a;

	}

	public static BitField leftShift(BitField a) {
		BitField b = a.copy();
		for (int i = 0; i < a.size() - 1; i++) {
			a.set(i + 1, b.get(i));
		}
		a.set(0, false);
		return a;

	}

	/**
	 * 
	 * @param b is the bitfield being entered that is going to be halved
	 * @return returns the part of the bits that are actually needed
	 */

	public static BitField halfBits(BitField b) {

		BitField out = new BitField(b.size() / 2);

		for (int i = 0; i < b.size() / 2; i++) {

			out.set(i, b.get(i));
		}

		return out;
	}

}
