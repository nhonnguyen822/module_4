package com.example.bai_tap_2.controller;

import com.example.bai_tap_2.dto.SongRequestDto;
import com.example.bai_tap_2.entity.Songs;
import com.example.bai_tap_2.service.ISongsService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("songs")
public class SongsController {
    private final ISongsService songsService;

    public SongsController(ISongsService songsService) {
        this.songsService = songsService;
    }

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("songList", songsService.findAll());
        return "song/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("songRequestDto", new SongRequestDto());
        return "song/create";
    }

    @PostMapping("save")
    public String save(@Validated @ModelAttribute SongRequestDto songRequestDto,
                       BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        Songs songs = new Songs();
        new SongRequestDto().validate(songRequestDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "song/create";
        }
        BeanUtils.copyProperties(songRequestDto, songs);
        songsService.save(songs);
        redirectAttributes.addFlashAttribute("message", "create success");
        return "redirect:/songs";
    }

    @GetMapping("/update/{id}")
    public String showUpdate(@PathVariable Long id, Model model) {
        Songs song = songsService.findById(id);
        SongRequestDto songRequestDto = new SongRequestDto();
        BeanUtils.copyProperties(song, songRequestDto);
        model.addAttribute("songRequestDto", songRequestDto);
        model.addAttribute("id", id);
        return "song/update";
    }


    @PostMapping("/update/{id}")
    public String update(@Validated @ModelAttribute SongRequestDto songRequestDto,
                         @PathVariable Long id, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new SongRequestDto().validate(songRequestDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "song/update";
        }

        Songs songs = new Songs();
        BeanUtils.copyProperties(songRequestDto, songs);
        songs.setId(id);
        songsService.save(songs);
        redirectAttributes.addFlashAttribute("message", "create success");
        return "redirect:/songs";
    }

    @PostMapping("delete")
    public String delete(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        songsService.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "delete success");
        return "redirect:/songs";
    }
}
