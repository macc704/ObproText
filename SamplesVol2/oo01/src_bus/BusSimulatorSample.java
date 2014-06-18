/**
 * �o�X�̉^�s���V�~�����[�g����T���v���v���O����
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

		// ��q�i�c���ƎR�{�j�𐶐�����
		Passenger tanaka = new Passenger();
		// -------------------(1)---------------------
		tanaka.name = "�c��";
		// -------------------(2)---------------------
		Passenger yamamoto = new Passenger();
		yamamoto.name = "�R�{";

		// �l�����s���o�X�𐶐�����
		Bus bus = new Bus();
		bus.destination = "�l����";
		// -------------------(3)---------------------

		// �o�X��i���A�e���|�[�g�A�l�����j�𐶐�����
		BusStop daiba = new BusStop();
		daiba.name = "���";
		BusStop teleport = new BusStop();
		teleport.name = "�e���|�[�g";
		BusStop hamamatsutyo = new BusStop();
		hamamatsutyo.name = "�l����";
		// -------------------(4)---------------------

		// �R�{�Ɠc�������̃o�X��Ńo�X�҂�������
		daiba.waitingPassengers[0] = yamamoto;
		daiba.waitingPassengers[1] = tanaka;
		// -------------------(5)---------------------

		// �o�X�����ɒ��
		daiba.stoppingBus = bus;
		// -------------------(6)---------------------

		// �R�{�Ɠc�������̃o�X��Ńo�X�҂��̗񂩂痣���
		daiba.waitingPassengers[0] = null;
		daiba.waitingPassengers[1] = null;
		// -------------------(7)---------------------

		// �R�{�Ɠc�����o�X�ɏ��
		bus.ridingPassengers[0] = yamamoto;
		bus.ridingPassengers[1] = tanaka;
		// -------------------(8)---------------------

		// �o�X�����𔭎�
		daiba.stoppingBus = null;
		// -------------------(9)---------------------

		// �o�X���e���|�[�g�ɒ��
		teleport.stoppingBus = bus;
		// -------------------(10)---------------------

		// �R�{���o�X���~���
		bus.ridingPassengers[0] = null;
		// -------------------(11)---------------------

		// �o�X���e���|�[�g�𔭎�
		teleport.stoppingBus = null;
		// -------------------(12)---------------------

		// �o�X���l�����ɒ��
		hamamatsutyo.stoppingBus = bus;
		// -------------------(13)---------------------

		// �c�����o�X���~���
		bus.ridingPassengers[1] = null;
		// -------------------(14)---------------------
	}
}
