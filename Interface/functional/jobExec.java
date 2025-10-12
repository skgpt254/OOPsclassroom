import java.util.*;

class jobExec {
        public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String jobName = s.nextLine();
        Runnable job = () -> System.out.println("Running background job: " + jobName);
        new Thread(job).start();
    }
}