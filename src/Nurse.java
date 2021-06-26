import java.util.PriorityQueue;
import java.util.Queue;

/** Class for The User which is Hospital Nurses*/
public class Nurse extends AbstractPerson implements Staff, Comparable<Nurse> {

    // Data Fields
    /** Patients those need take caring.*/
    private  Queue<Patient> requests;

    /** Vaccine Appointments */
    private  Queue<VaccineAppointment> appointments;

    // Constructor
    public Nurse(String name, String surname, String ID, String phoneNum, String password) {
        super(name, surname, ID,phoneNum, password);
        requests = new PriorityQueue<>();
        appointments = new PriorityQueue<>();
    }

    /** Vaccinates head of queue and removes him/her from queue. */
    public VaccineAppointment vaccinate(){
        if (appointments.peek() == null)
            return null;
        VaccineAppointment appointment = appointments.poll();
        appointment.setStatus(StatusType.FINISHED);
        return appointment;
    }

    public int getAppointmentNumber() {
        return appointments.size();
    }

    /** Take cares head of queue and removes him/her from queue. */
    public Patient  takeCare(){
        if (requests.peek() == null)
            return null;
        Patient patient = requests.poll();
        return patient;
    }

    /** add method.
        @param appointment The appointment being inserted.
        @return true if appointment inserting in queue is successful,
                otherwise false.
     */
    public boolean add(VaccineAppointment appointment){
        return (appointments.add(appointment));
    }

    @Override
    public String toString() {
        return "Nurse{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", ID='" + ID + '\'' +
                ", password='" + password + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", requests=" + requests +
                ", appointments=" + appointments +
                '}';
    }

    @Override
    public int compareTo(Nurse o) {
        return getID().compareTo(o.getID());
    }
}
