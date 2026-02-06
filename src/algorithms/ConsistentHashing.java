package algorithms;

import java.security.*;
import java.util.*;

public class ConsistentHashing {
    private final int numReplicas; // Number of virtual nodes per server
    private final TreeMap<Long, String> ring; // Hash ring storing virtual nodes
    private final Set<String> servers; // Set of physical servers

    public ConsistentHashing(List<String> servers, int numReplicas) {
        this.numReplicas = numReplicas;
        this.ring = new TreeMap<>();
        this.servers = new HashSet<>();

        // Add each server to the hash ring
        for (String server : servers) {
            addServer(server);
        }
    }

    private long hash(String key) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(key.getBytes());
            byte[] digest = md.digest();
            return ((long) (digest[0] & 0xFF) << 24) |
                    ((long) (digest[1] & 0xFF) << 16) |
                    ((long) (digest[2] & 0xFF) << 8) |
                    ((long) (digest[3] & 0xFF));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 algorithm not found", e);
        }
    }

    public void addServer(String server) {
        servers.add(server);
        for (int i = 0; i < numReplicas; i++) {
            long hash = hash(server + "-" + i); // Unique hash for each virtual node
            ring.put(hash, server);
        }
    }

    public void removeServer(String server) {
        if (servers.remove(server)) {
            for (int i = 0; i < numReplicas; i++) {
                long hash = hash(server + "-" + i);
                ring.remove(hash);
            }
        }
    }

    public String getServer(String key) {
        if (ring.isEmpty()) {
            return null; // No servers available
        }

        long hash = hash(key);
        // Find the closest server in a clockwise direction
        Map.Entry<Long, String> entry = ring.ceilingEntry(hash);
        if (entry == null) {
            // If we exceed the highest node, wrap around to the first node
            entry = ring.firstEntry();
        }
        return entry.getValue();
    }

    public void printRing(){
        ring.forEach((key, value) -> {
            System.out.println(key+" - " +value);
        });
    }

    public static void main(String[] args) {
        List<String> servers = Arrays.asList("S0", "S1", "S2");
        ConsistentHashing ch = new ConsistentHashing(servers, 3);
        ch.printRing();
        // Step 2: Assign requests (keys) to servers
        System.out.println("UserC is assigned to: " + ch.getServer("UserC"));
        System.out.println("UserB is assigned to: " + ch.getServer("UserB"));

        // Step 3: Add a new server dynamically

        ch.addServer("S3");
        ch.printRing();
        System.out.println("UserC is now assigned to: " + ch.getServer("UserC"));
        System.out.println("UserB is assigned to: " + ch.getServer("UserB"));
        // Step 4: Remove a server dynamically
        ch.removeServer("S2");
        ch.printRing();
        System.out.println("UserC is now assigned to: " + ch.getServer("UserC"));
        System.out.println("UserB is assigned to: " + ch.getServer("UserB"));
    }

}
