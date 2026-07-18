class Solution {

    Map<String, PriorityQueue<String>> graph = new HashMap<>();
    List<String> ans = new ArrayList<>();

    public List<String> findItinerary(List<List<String>> tickets) {

        for (List<String> ticket : tickets) {
            graph.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>())
                 .offer(ticket.get(1));
        }

        dfs("JFK");

        Collections.reverse(ans);

        return ans;
    }

    public void dfs(String airport) {

        PriorityQueue<String> nextAirports = graph.get(airport);

        while (nextAirports != null && !nextAirports.isEmpty()) {
            dfs(nextAirports.poll());
        }

        ans.add(airport);
    }
}