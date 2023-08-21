package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entities.Hospital;
import peaksoft.services.HospitalService;

@Controller
@RequestMapping("/hospitals")
@RequiredArgsConstructor

public class HospitalAPI {
    private final HospitalService hospitalService;

    @GetMapping
    public String getAllHospitals(Model model,
                                  @RequestParam (required = false) String name,
                                  @RequestParam (required = false) String address){
        model.addAttribute("allHospitals",hospitalService.getAllHospitals(name,address));
        return "hospital/getAll";
    }
    @GetMapping("/new")
    public String createHospital(Model model){
        model.addAttribute("newHospital",new Hospital());
        return "hospital/newHospital";
    }
    @PostMapping("/save")
    public String saveHospital(@ModelAttribute("newHospital") Hospital hospital){
        hospitalService.saveHospital(hospital);
        return "redirect:/hospitals";
    }
    @DeleteMapping("{hospitalId}/delete")
    public String deleteHospital(@PathVariable ("hospitalId") Long id){
        hospitalService.deleteHospital(id);
        return "redirect:/hospitals";
    }
    @GetMapping("update/{hospitalId}")
    public String updatePage(@PathVariable Long hospitalId, Model model){
        model.addAttribute("currentHospital",hospitalService.getHospitalById(hospitalId));
        return "hospital/updatePage";
    }
    @PostMapping("/edit/{hospitalId}")
    public String editHospital(@ModelAttribute Hospital newHospital,
                               @PathVariable Long hospitalId){
        hospitalService.updateHospital(hospitalId,newHospital);
        return "redirect:/hospitals";
    }
    @GetMapping("/{hospitalId}/enter")
    public String enterToHospital(@PathVariable Long hospitalId, Model model) {
        Hospital hospital = hospitalService.getHospitalById(hospitalId);
        model.addAttribute("hospital", hospital);
        return "hospital/enterToHospital";
    }







}
