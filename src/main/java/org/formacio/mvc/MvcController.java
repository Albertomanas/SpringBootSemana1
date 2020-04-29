package org.formacio.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.formacio.component.ServeiAlumnat;

@Controller
public class MvcController {
	// referencia a ServeiAlumna (vía dependecia).
	// sense referencia a RepositoriAlumnes.
	@Autowired
	private ServeiAlumnat serveiAlumnat;

	@RequestMapping(path = "/alumnes")
	@ResponseBody
	public int nomAlumnes() {
		return serveiAlumnat.nomAlumne();
	}
}
