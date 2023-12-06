import java.io.*;
import java.util.*;

public class SecretSantaFileCreator {

    public static void main(String[] args) {
        // Load participants' data from file
        Map<String, String> participants = loadParticipants("G:\\GitRepo\\SecretSantaFileCreator\\participants.txt");

        // Map emails to Secret Santa names
        Map<String, String> secretSantaMap = assignSecretSanta(participants);

        // Create files for each participant with Secret Santa assignment
        for (Map.Entry<String, String> entry : participants.entrySet()) {
            String email = entry.getKey();
            String recipientName = secretSantaMap.get(email);

            // Create a file for the participant
            createFile(entry.getValue(), recipientName);
        }
    }

    // Method to load participants from file
    private static Map<String, String> loadParticipants(String fileName) {
        Map<String, String> participants = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String name = line.trim();
                String email = br.readLine().trim();
                participants.put(email, name);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return participants;
    }

    // Method to assign Secret Santa names to emails
    private static Map<String, String> assignSecretSanta(Map<String, String> participants) {
        List<String> names = new ArrayList<>(participants.values());
        Collections.shuffle(names);

        Map<String, String> secretSantaMap = new HashMap<>();
        int i = 0;
        for (String email : participants.keySet()) {
            String secretSantaName = names.get(i);
            if (!participants.get(email).equals(secretSantaName)) {
                secretSantaMap.put(email, secretSantaName);
                i++;
            } else {
                // If the selected name matches the participant's name, get the next name
                secretSantaName = names.get((i + 1) % names.size());
                secretSantaMap.put(email, secretSantaName);
                i = (i + 2) % names.size(); // Move to the next available name
            }
        }
        return secretSantaMap;
    }


    // Method to create a file for each participant with Secret Santa assignment
    private static void createFile(String participantName, String secretSantaName) {
        String fileName = participantName + "_SecretSanta.txt";
        try (PrintWriter writer = new PrintWriter(fileName)) {
            writer.println("You are assigned as Secret Santa to: " + secretSantaName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
