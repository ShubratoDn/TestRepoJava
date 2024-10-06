package com.example.demo.config;
import org.springframework.util.PathMatcher;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SuffixPathMatcher implements PathMatcher {

    private final Set<String> allowedSuffixes;

    public SuffixPathMatcher(Set<String> allowedSuffixes) {
        this.allowedSuffixes = allowedSuffixes;
    }

    @Override
    public boolean isPattern(String path) {
        // Allow paths that have one of the allowed suffixes
        return allowedSuffixes.stream().anyMatch(path::endsWith);
    }

    @Override
    public boolean match(String pattern, String path) {
        // Only allow matching for paths that end with allowed suffixes
        return allowedSuffixes.stream().anyMatch(path::endsWith);
    }

    @Override
    public boolean matchStart(String pattern, String path) {
        return match(pattern, path);
    }

    @Override
    public String extractPathWithinPattern(String pattern, String path) {
        return path;
    }

    @Override
    public Map<String, String> extractUriTemplateVariables(String pattern, String path) {
        return new HashMap<>();
    }

    @Override
    public String combine(String pattern1, String pattern2) {
        return pattern1 + pattern2;
    }

    @Override
    public Comparator<String> getPatternComparator(String path) {
        return String::compareTo;
    }

//    @Override
    public boolean isPattern() {
        return false;
    }
    
    
}
