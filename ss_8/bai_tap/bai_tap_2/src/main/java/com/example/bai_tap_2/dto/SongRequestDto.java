package com.example.bai_tap_2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SongRequestDto implements Validator {
    private String songName;
    private String artistPerforming;
    private String musicGenre;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongRequestDto songRequestDto = (SongRequestDto) target;
        if (songRequestDto.getSongName().isEmpty()) {
            errors.rejectValue("songName", "emptyError", "");
        } else if (songRequestDto.getSongName().length() > 800) {
            errors.rejectValue("songName", "songNameLengthError", "");
        } else if (!songRequestDto.getSongName().matches("^([\\p{Lu}0-9][\\p{L}\\p{N}]*)(\\s[\\p{Lu}0-9][\\p{L}\\p{N}]*)*$")) {
            errors.rejectValue("songName", "formatError", "");
        }

        if (songRequestDto.getArtistPerforming().isEmpty()) {
            errors.rejectValue("artistPerforming", "emptyError", "");
        } else if (songRequestDto.getArtistPerforming().length() > 300) {
            errors.rejectValue("artistPerforming", "artistPerformingLengthError", "");
        } else if (!songRequestDto.getArtistPerforming().matches("^([\\p{Lu}0-9][\\p{L}\\p{N}]*)(\\s[\\p{Lu}0-9][\\p{L}\\p{N}]*)*$")) {
            errors.rejectValue("artistPerforming", "formatError", "");
        }

        if (songRequestDto.getMusicGenre().isEmpty()) {
            errors.rejectValue("musicGenre", "emptyError", "");
        } else if (songRequestDto.getMusicGenre().length() > 1000) {
            errors.rejectValue("musicGenre", "musicGenreLengthError", "");
        } else if (!songRequestDto.getMusicGenre().matches("^([\\p{Lu}0-9][\\p{L}\\p{N}]*[,]?)(\\s[\\p{Lu}0-9][\\p{L}\\p{N}]*[,]?)*$")) {
            errors.rejectValue("musicGenre", "formatError", "");
        }
    }
}
