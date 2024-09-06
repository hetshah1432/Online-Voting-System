package votingsystem;

import java.util.*;

public class Admin {
    private Map<String, Integer> candidates = new HashMap<>();
    private Set<String> voters = new HashSet<>();  // Track who has voted

    // Add a candidate to the election
    public void addCandidate(String candidate) {
        if (!candidates.containsKey(candidate)) {
            candidates.put(candidate, 0);  // Initialize vote count for the candidate
            System.out.println(candidate + " added to the election.");
        } else {
            System.out.println(candidate + " is already in the list.");
        }
    }

    // Cast a vote for a candidate, ensuring the voter hasn't already voted
    public void castVote(String voterName, String candidate) throws Exception {
        if (voters.contains(voterName)) {
            throw new Exception("You have already voted.");
        }
        if (!candidates.containsKey(candidate)) {
            throw new Exception("Invalid candidate!");
        }

        candidates.put(candidate, candidates.get(candidate) + 1);
        voters.add(voterName);
        System.out.println("Vote cast for " + candidate + " by " + voterName);
    }

    // Get the election results and show who's winning or if there is a tie
    public String getResults() {
        if (candidates.isEmpty()) {
            return "No candidates available.";
        }

        // Find the maximum number of votes
        int maxVotes = Collections.max(candidates.values());

        // Collect all candidates who have the maximum number of votes
        List<String> topCandidates = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : candidates.entrySet()) {
            if (entry.getValue() == maxVotes) {
                topCandidates.add(entry.getKey());
            }
        }

        // Check if there's a tie
        if (topCandidates.size() > 1) {
            return "It's a tie between: " + String.join(", ", topCandidates) + " with " + maxVotes + " votes each.";
        } else {
            return topCandidates.get(0) + " is winning with " + maxVotes + " votes.";
        }
    }

    // Get the list of candidates
    public List<String> getCandidates() {
        return new ArrayList<>(candidates.keySet());
    }
}
