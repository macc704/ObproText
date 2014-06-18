/**
 * バス停クラス バスが停車して、待っている客が乗ることが出来る
 * 
 * @author bam
 * @version $Id: BusStop.java,v 1.3 2004/04/30 06:36:10 bam Exp $
 */
public class BusStop {

	String name; // 停留所名
	Bus stoppingBus; // 停車中のバス
	Passenger[] waitingPassengers = new Passenger[3]; // 待っている客

}