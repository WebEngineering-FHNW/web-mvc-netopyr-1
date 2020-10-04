package ch.fhnw.webec.converter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ConverterController {

    @GetMapping("convert")
    public ModelAndView convert(@RequestParam(required = false) Double feet, @RequestParam(required = false) Double inches) {
        final double feetValue = feet != null? feet : 0;
        final double inchesValue = inches != null? inches : 0;
        final double result = (12 * feetValue + inchesValue) * 2.54;
        final int cm = (int) result;
        final int mm = (int)Math.round(10 * (result - cm));
        final Map<String, Object> model = new HashMap<>();
        model.put("feet", feetValue);
        model.put("inches", inchesValue);
        model.put("cm", cm);
        model.put("mm", mm);
        return new ModelAndView("ConverterOutput", model);
    }

}
