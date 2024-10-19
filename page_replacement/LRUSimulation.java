package com.mycompany.page_replacement;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class LRUSimulation {
    private int totalPages;
    private int totalFrames;
    private String input;
    private List<Integer> pageReferences;
    private LinkedHashSet<Integer> frames;
    private int pageHitCount;
    private int pageFaultCount;
    private double hitRatio;
    private double missRatio;

    public LRUSimulation(int totalPages, int totalFrames, String input) {
        this.totalPages = totalPages;
        this.totalFrames = totalFrames;
        this.input = input;
    }

    public void simulate() {
        pageReferences = new ArrayList<>();
        for (String s : input.split(" ")) {
            pageReferences.add(Integer.parseInt(s));
        }

        frames = new LinkedHashSet<>();
        for (int i = 0; i < totalFrames; i++) {
            frames.add(-1);
        }

        pageHitCount = 0;
        pageFaultCount = 0;

        for (int pageReference : pageReferences) {
            if (frames.contains(pageReference)) {
                pageHitCount++;
            } else {
                if (frames.size() < totalFrames) {
                    frames.add(pageReference);
                } else {
                    frames.remove(frames.iterator().next());
                    frames.add(pageReference);
                }
                pageFaultCount++;
            }
        }

        hitRatio = (double) pageHitCount / totalPages;
        missRatio = (double) pageFaultCount / totalPages;
    }

    public String getResults() {
        StringBuilder sb = new StringBuilder();

        sb.append("Total number of pages: ").append(totalPages).append("\n");
        sb.append("Number of page hits: ").append(pageHitCount).append("\n");
        sb.append("Number of page faults: ").append(pageFaultCount).append("\n");
        sb.append("Hit Ratio: ").append(String.format("%.2f", hitRatio)).append("\n");
        sb.append("Miss Ratio: ").append(String.format("%.2f", missRatio)).append("\n");

        return sb.toString();
    }
}
