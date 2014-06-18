/**
 * バスの運行をシミュレートするサンプルプログラム
 * 
 * @author bam
 * @version $Id: BusSimulatorSample.java,v 1.1 2004/04/21 11:47:33 rintaro Exp $
 */
public class BusSimulatorSample {

	public static void main(String[] args) {
		BusSimulatorSample busSample = new BusSimulatorSample();
		busSample.main();
	}

	void main() {

		// 乗客（田中と山本）を生成する
		Passenger tanaka = new Passenger();
		// -------------------(1)---------------------
		tanaka.name = "田中";
		// -------------------(2)---------------------
		Passenger yamamoto = new Passenger();
		yamamoto.name = "山本";

		// 浜松町行きバスを生成する
		Bus bus = new Bus();
		bus.destination = "浜松町";
		// -------------------(3)---------------------

		// バス停（台場、テレポート、浜松町）を生成する
		BusStop daiba = new BusStop();
		daiba.name = "台場";
		BusStop teleport = new BusStop();
		teleport.name = "テレポート";
		BusStop hamamatsutyo = new BusStop();
		hamamatsutyo.name = "浜松町";
		// -------------------(4)---------------------

		// 山本と田中が台場のバス停でバス待ちをする
		daiba.waitingPassengers[0] = yamamoto;
		daiba.waitingPassengers[1] = tanaka;
		// -------------------(5)---------------------

		// バスが台場に停車
		daiba.stoppingBus = bus;
		// -------------------(6)---------------------

		// 山本と田中が台場のバス停でバス待ちの列から離れる
		daiba.waitingPassengers[0] = null;
		daiba.waitingPassengers[1] = null;
		// -------------------(7)---------------------

		// 山本と田中がバスに乗る
		bus.ridingPassengers[0] = yamamoto;
		bus.ridingPassengers[1] = tanaka;
		// -------------------(8)---------------------

		// バスが台場を発車
		daiba.stoppingBus = null;
		// -------------------(9)---------------------

		// バスがテレポートに停車
		teleport.stoppingBus = bus;
		// -------------------(10)---------------------

		// 山本がバスを降りる
		bus.ridingPassengers[0] = null;
		// -------------------(11)---------------------

		// バスがテレポートを発車
		teleport.stoppingBus = null;
		// -------------------(12)---------------------

		// バスが浜松町に停車
		hamamatsutyo.stoppingBus = bus;
		// -------------------(13)---------------------

		// 田中がバスを降りる
		bus.ridingPassengers[1] = null;
		// -------------------(14)---------------------
	}
}
