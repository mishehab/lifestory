package com.mycompany.page_replacement;

import java.util.ArrayList;
import java.util.List;

public class FIFOSimulation {
    private int totalPages;
    private int totalFrames;
    private String input;
    private List<Integer> pageReferences;
    private List<Integer> frames;
    private int pageHitCount;
    private int pageFaultCount;
    private double hitRatio;
    private double missRatio;

    public FIFOSimulation(int totalPages, int totalFrames, String input) {
        this.totalPages = totalPages;
        this.totalFrames = totalFrames;
        this.input = input;
    }

    public void simulate() {
        pageReferences = new ArrayList<>();
        for (String s : input.split(" ")) {
            pageReferences.add(Integer.parseInt(s));
        }

        frames = new ArrayList<>();
        for (int i = 0; i < totalFrames; i++) {
            frames.add(-1);
        }

        pageHitCount = 0;
        pageFaultCount = 0;

        List<Integer> remainingPageReferences = new ArrayList<>(pageReferences);

        for (int i = 0; i < pageReferences.size(); i++) {
            int pageReference = pageReferences.get(i);

            if (frames.contains(pageReference)) {
                pageHitCount++;
            } else {
                if (frames.size() < totalFrames) {
                    frames.add(pageReference);
                } else {
                    frames.remove(0);
                    frames.add(pageReference);
                }
                pageFaultCount++;
            }

            remainingPageReferences.remove(Integer.valueOf(pageReference));
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
