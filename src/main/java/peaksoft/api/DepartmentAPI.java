package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entities.Department;
import peaksoft.services.DepartmentService;


@Controller
@RequestMapping("/departments/{hospId}")
@RequiredArgsConstructor

public class DepartmentAPI {
    private final DepartmentService departmentService;

    @GetMapping
    public String getAllDeps(Model model, @PathVariable Long hospId) {
        model.addAttribute("allDepartments", departmentService.getAllDepartments(hospId));
        return "department/allDepartment";
    }


    @GetMapping("/new")
    public String createDep(Model model, @PathVariable Long hospId) {
        model.addAttribute("newDep", new Department());
        model.addAttribute("hospId", hospId);
        return "department/newDep";
    }

    @PostMapping("/save")
    public String saveDepartment(@ModelAttribute Department department, @PathVariable Long hospId) {
        departmentService.saveDepartment(department, hospId);
        return "redirect:/departments/" + hospId;
    }

    @GetMapping("/enter/{depId}")
    public String enterToDepsChapter(@PathVariable Long depId, @PathVariable Long hospId) {
        departmentService.getDepartmentById(depId, hospId);
        return "department/enterToDepsChapter";
    }

    @GetMapping("/update/{depId}")
    public String updatePage (@PathVariable Long depId, @PathVariable Long hospId, Model model){
        model.addAttribute("depId",depId);
        model.addAttribute("hospitalId",hospId);
        model.addAttribute("currentDepartment",departmentService.getDepartmentById(depId,hospId));
        return "department/updatePage";
    }
    //departments/{hospId}/edit/{depId}
    @PostMapping("/edit/{depId}")
    public String editDep (@ModelAttribute("currentDepartment") Department newDepartment,
                           @PathVariable Long depId,
                           @PathVariable Long hospId){
        departmentService.updateDepartmentByHospId(depId,hospId,newDepartment);
        return "redirect:/departments/"+departmentService.getDepById(depId).getHospital().getId();
    }

}
