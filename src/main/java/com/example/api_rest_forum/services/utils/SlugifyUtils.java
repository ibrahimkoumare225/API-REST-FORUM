package com.example.api_rest_forum.services.utils;

import com.github.slugify.Slugify;

import java.util.UUID;

public final class SlugifyUtils {
    private SlugifyUtils() {
    }

    public static String generate(String input) {
        String value = String.format("%s,%s", input, UUID.randomUUID());
        final Slugify slg = Slugify.builder().underscoreSeparator(true).build();
        return slg.slugify(value);
    }
}
