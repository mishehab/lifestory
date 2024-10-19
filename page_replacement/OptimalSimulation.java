package com.mycompany.page_replacement;

import java.util.ArrayList;
import java.util.List;

public class OptimalSimulation {
    private int totalPages;
    private int totalFrames;
    private String input;
    private List<Integer> pageReferences;
    private List<Integer> frames;
    private int pageHitCount;
    private int pageFaultCount;
    private double hitRatio;
    private double missRatio;

    public OptimalSimulation(int totalPages, int totalFrames, String input) {
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
        pageHitCount = 0;
        pageFaultCount = 0;

        for (int i = 0; i < pageReferences.size(); i++) {
            int pageReference = pageReferences.get(i);

            if (frames.contains(pageReference)) {
                pageHitCount++;
            } else {
                if (frames.size() < totalFrames) {
                    frames.add(pageReference);
                } else {
                    int indexToReplace = -1;
                    int farthestReferenceIndex = -1;

                    for (int frameIndex = 0; frameIndex < frames.size(); frameIndex++) {
                        int frame = frames.get(frameIndex);
                        int nextIndex = findNextReferenceIndex(pageReferences, frame, i + 1);

                        if (nextIndex == -1) {
                            indexToReplace = frameIndex;
                            break;
                        } else if (nextIndex > farthestReferenceIndex) {
                            farthestReferenceIndex = nextIndex;
                            indexToReplace = frameIndex;
                        }
                    }

                    frames.set(indexToReplace, pageReference);
                }
                pageFaultCount++;
            }
        }

        hitRatio = (double) pageHitCount / pageReferences.size();
        missRatio = (double) pageFaultCount / pageReferences.size();
    }

    private int findNextReferenceIndex(List<Integer> references, int page, int startIndex) {
        for (int i = startIndex; i < references.size(); i++) {
            if (references.get(i) == page) {
                return i;
            }
        }
        return -1;
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
