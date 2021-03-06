/**
 *
 */
package br.com.acsp.curso.domain.socio;

import br.com.acsp.curso.common.AbstractController;
import br.com.acsp.curso.domain.aeronave.AeronaveService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

/**
 * @author pedrosa
 */

@Controller
public class SocioController extends AbstractController {

    private static final Log logger = LogFactory.getLog(SocioController.class);

    @Autowired
    private SocioService socioService;

    @Autowired
    private AeronaveService aeronaveService;

    /**
     * Este metodo adiciona o socio ao (form) request, basta usar o form com o
     * nome de "socio"
     *
     * @return
     */
    @ModelAttribute("socio")
    public Socio getSocio() {
        return new Socio();
    }

    @RequestMapping("/socios/spa")
    public String spa(ModelMap map) {
        return "socio/lista";
    }

    @RequestMapping("/socios")
    @ResponseBody
    public Collection<Socio> lista(ModelMap map) {
        return socioService.listarTodos();
    }

    // Nem todos os browser suportam DELETE
    @RequestMapping(value = "/socio/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void exclui(@PathVariable("id") String id) {
        socioService.excluirPorId(id);
    }

    @RequestMapping(value = "/socio/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Socio buscaPorId(@PathVariable("id") String id) {
        return socioService.obtemPorId(id);
    }

    @RequestMapping(value = "/socio", method = RequestMethod.POST)
    @ResponseBody
    public void salvarOuAtualizar(@Valid Socio socio, BindingResult result) {
        validateBindingResult(result);
        socioService.salvar(socio);
    }
}