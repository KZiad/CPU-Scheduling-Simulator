import java.util.*;

public class CPU_Simulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=============================");
        System.out.print("Enter number of processes: ");
        int numProcs = scanner.nextInt();

        System.out.print("Enter the Round Robin Quantum: ");
        int quantum = scanner.nextInt();

        System.out.print("Enter the switching context time: ");
        int contextSwitch = scanner.nextInt();

        ArrayList<Process> processes = new ArrayList<Process>();
        for (int i = 0; i < numProcs; i++) {

            System.out.println("=============================");

            System.out.print("Process ID: ");
            int id = scanner.nextInt();

            System.out.print("Arrival Time: ");
            int arrivalTime = scanner.nextInt();

            System.out.print("Burst Time: ");
            int burstTime = scanner.nextInt();

            System.out.print("Priority: ");
            int priority = scanner.nextInt();

            processes.add(new Process(id, arrivalTime, burstTime, priority, quantum));
        }

        // SJF (Pb1)
        System.out.println("=============================");
        System.out.println("--SJF SCHEDULER START--");
        SJF sjf = new SJF(processes);
        sjf.runSJF();
        System.out.println("--SJF SCHEDULER END--");
        System.out.println("=============================");

        System.out.println();

        // SRTF (Pb2)
        System.out.println("=============================");
        System.out.println("--SRTF SCHEDULER START--");
        SRTFScheduler srtfScheduler = new SRTFScheduler(processes);
        srtfScheduler.runSRTF();
        System.out.println("--SRTF SCHEDULER END--");
        System.out.println("=============================");

        System.out.println();

        // Priority Scheduler (Pb3)
        System.out.println("=============================");
        System.out.println("--PRIORITY SCHEDULER START--");
        PriorityScheduler priorityScheduler = new PriorityScheduler(processes);
        priorityScheduler.run();
        System.out.println("--PRIORITY SCHEDULER END--");
        System.out.println("=============================");

        System.out.println();

        // AG Scheduler (Pb4)
        System.out.println("=============================");
        System.out.println("--AG SCHEDULER START--");
        AG ag = new AG(processes);
        ag.run();
        System.out.println("--AG SCHEDULER END--");
        System.out.println("=============================");
        System.out.println();

    }
}
