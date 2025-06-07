package Bodlogo11;

import java.util.*;

public class Dasgal11 {

    static class Node {
        Map<Character, Node> children = new HashMap<>();
        Node fail;
        List<Integer> geneIndices = new ArrayList<>();
    }

    static class AhoCorasick {
        Node root = new Node();

        // Генүүдийг Trie модонд нэмэх
        void addGene(String gene, int index) {
            Node node = root;
            for (char c : gene.toCharArray()) {
                node = node.children.computeIfAbsent(c, k -> new Node());
            }
            node.geneIndices.add(index);
        }

        // Failure линкүүдийг байгуулах
        void buildFailures() {
            Queue<Node> queue = new LinkedList<>();
            for (Node child : root.children.values()) {
                child.fail = root;
                queue.add(child);
            }

            while (!queue.isEmpty()) {
                Node current = queue.poll();
                for (Map.Entry<Character, Node> entry : current.children.entrySet()) {
                    char c = entry.getKey();
                    Node child = entry.getValue();
                    Node failNode = current.fail;
                    while (failNode != null && !failNode.children.containsKey(c)) {
                        failNode = failNode.fail;
                    }
                    child.fail = (failNode != null) ? failNode.children.get(c) : root;
                    child.geneIndices.addAll(child.fail.geneIndices);
                    queue.add(child);
                }
            }
        }

        // DNA гинж дотор генүүдийг хайх
        long search(String dna, int start, int end, String[] genes, int[] health) {
            long totalHealth = 0;
            Node node = root;
            for (char c : dna.toCharArray()) {
                while (node != root && !node.children.containsKey(c)) {
                    node = node.fail;
                }
                node = node.children.getOrDefault(c, root);
                for (int index : node.geneIndices) {
                    if (index >= start && index <= end) {
                        totalHealth += health[index];
                    }
                }
            }
            return totalHealth;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] genes = new String[n];
        for (int i = 0; i < n; i++) {
            genes[i] = scanner.next();
        }
        int[] health = new int[n];
        for (int i = 0; i < n; i++) {
            health[i] = scanner.nextInt();
        }
        int s = scanner.nextInt();

        AhoCorasick ac = new AhoCorasick();
        for (int i = 0; i < n; i++) {
            ac.addGene(genes[i], i);
        }
        ac.buildFailures();

        long minHealth = Long.MAX_VALUE;
        long maxHealth = Long.MIN_VALUE;

        for (int i = 0; i < s; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            String dna = scanner.next();
            long totalHealth = ac.search(dna, start, end, genes, health);
            minHealth = Math.min(minHealth, totalHealth);
            maxHealth = Math.max(maxHealth, totalHealth);
        }

        System.out.println(minHealth + " " + maxHealth);
        scanner.close();
    }
}
