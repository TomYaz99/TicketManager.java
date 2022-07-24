/*
* HeapPriorityQueue.java
*
* An implementation of a minimum PriorityQueue using a heap.
* based on the implementation in "Data Structures and Algorithms
* in Java", by Goodrich and Tamassia
*
* This implementation will throw a Runtime, HeapEmptyException
*	if the heap is empty and removeLow is called.
*
* This implementation will throw a Runtime, HeapFullException
*	if the heap is full and insert is called.
*
*/
@SuppressWarnings({"rawtypes", "unchecked"})
public class HeapPriorityQueue implements PriorityQueue {

	protected final static int DEFAULT_SIZE = 10000;
	
	protected Comparable[] storage;
	protected int currentSize;

	/*
	 * Constructor that initializes the array to hold DEFAULT_SIZE elements
	 */
	public HeapPriorityQueue() {
		// TODO: implement this
		storage = new Comparable[DEFAULT_SIZE +1];
		currentSize = 0;
		
		// if using a 1-based implementation, remember to allocate an 
		// extra space in the array since index 0 is not used. 
	}
	
	/*
	 * Constructor that initializes the array to hold size elements
	 */
	public HeapPriorityQueue(int size) {
		// TODO: implement this

		storage = new Comparable[size+1]; 
		currentSize = 0;
		
		// if using a 1-based implementation, remember to allocate an 
		// extra space in the array since index 0 is not used. 
	}

	public void insert (Comparable element) throws HeapFullException {
		// TODO: implement this
		if(currentSize + 1 == storage.length){ 
			throw new HeapFullException();
		}

		storage[currentSize+1] = element;
		currentSize ++;
		bubbleUp(currentSize); 


		
		// When inserting the first element, choose whether to use 
		// a 0-based on 1-based implementation. Whatever you choose,
		// make sure your implementation for the rest of the program
		// is consistent with this choice.		
    }
	
	public void bubbleUp(int index) {
		// TODO: implement this
		if(index > 1){
			if(storage[index].compareTo(storage[index/2]) < 0){
				swap(index, index/2);
				bubbleUp(index/2);
			}
		}
	}
			
	public Comparable removeMin() throws HeapEmptyException {
		// TODO: implement this
		if(currentSize == 0){
			throw new HeapEmptyException();
		}
		Comparable minValue = storage[1]; 
		storage[1] = storage[currentSize]; 
		storage[currentSize] = minValue; 
		currentSize--;
  		bubbleDown(1);
  		return minValue;
		
	}
	
	private void bubbleDown(int index) {
		// TODO: implement this
		if(!isLeaf(index)){
			int minIndex = minChild(index);
			if(storage[index].compareTo(storage[minIndex]) > 0){
				swap(index, minIndex);
				bubbleDown(minIndex);
			}
		}

	}

	public boolean isEmpty(){
		// TODO: implement this

		if(currentSize == 0){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean isFull() {
		// TODO: implement this
		if(currentSize == storage.length){
			return true;
		}else{

			return false;

		}
		
		 // so it compiles
	}
	
	public int size () {
		// TODO: implement this
		
		return currentSize; // so it compiles
	}

	public String toString() {
		String s = "";
		String sep = "";
		// This implementation of toString assumes you 
		// are using a 1-based approach. Update the initial
		// and final value for i if using a 0-based
		for(int i=1; i<=currentSize; i++) {
			s += sep + storage[i];
			sep = " ";
		}
		return s;
	}

	public void swap(int index, int index2){
		Comparable x = storage[index];
		storage[index] = storage[index2];
		storage[index2] = x;

	}

	public boolean isLeaf(int index){
		int left = index*2;
		int right = index*2 +1;
		return left > currentSize;
	}

	public int minChild(int index){
		int left = index*2;
		int right = index*2 +1;
		if(right > currentSize){
			return left;
		}
		if(storage[left].compareTo(storage[right]) < 0){
			return left;
		} else{
			return right;
		}
	}



}
