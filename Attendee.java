/*
 * represents a concert attendee arriving at a concert
 *
 * Some methods are implemented for you.
 * Read through the documentation in order
 * to implement the compareTo method
 */

public class Attendee implements Comparable<Attendee>{

	private String name;
	private Ticket eventTicket;
	private Time arrivalTime;

	public Attendee(String name, Ticket eventTicket, Time arrivalTime) {
		this.name = name;
		this.eventTicket = eventTicket;
		this.arrivalTime = arrivalTime;
	}
	
	public String getName() {
		return name;
	}

	public Ticket getEventTicket() {
		return this.eventTicket;
	}

	public Time getArrivalTime() {
		return arrivalTime;
	}

	public String toString() {
		return name + " - " + eventTicket.toString();
	}

	/*
	 * Purpose: returns the result of comparing this attendee with
	 *          other attendee based on their tickets and arrival time
	 *          The tickets are first compared, and the higher priority
	 *          ticket results in a higher priority attendee.
 	 *	        if ticketTypes are equal, the attendee who arrived
	 *          first is given priority
	 * Parameters: Attendee other
	 * Precondition: other is not null
	 * Returns: a value < 0 if this attendee is before other attendee // return less than 0
	 *          a value == 0 if this attendee is the same as other attendee//return equal to 0
	 *          a value > 0 if this attendee is after other attendee// grater than 0
	 * HINT: the Time class implements compareable too!
	 */
	public int compareTo(Attendee other) {
		// TODO: implement this
		if(eventTicket.compareTo(other.getEventTicket())<0){
			return -1;
		}else if(eventTicket.compareTo(other.getEventTicket()) == 0){
			if(arrivalTime.compareTo(other.getArrivalTime()) < 0){
				return -1;
			}else if (arrivalTime.compareTo(other.getArrivalTime()) == 0){
				return 0;
			}else{
				return 1;
			}
			
		}
		
		return 1; // so it compiles
	}

	/* 
	 * Purpose: determines whether this attendees name and 
	 *          ticket are equal to the other attendee
	 * Parameters: Attendee other
	 * Precondition: other is not null
	 * Returns: true if this Attendee is the same as other, false otherwise
	 */
	public boolean equals(Attendee other) {
		return this.name.equals(other.name) 
			&& this.eventTicket.equals(other.eventTicket);
	}
}

