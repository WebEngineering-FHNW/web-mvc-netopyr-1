package ch.fhnw.webec.converter;

import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.Assertions.assertThat;

class ConverterControllerTest {

    @Test
    void testInchesConversion() {
        // given:
        final ConverterController controller = new ConverterController();

        // when:
        final ModelAndView result = controller.convert(0.0, 5.0);

        // then:
        assertThat(result.getModel()).containsEntry("cm", 12);
        assertThat(result.getModel()).containsEntry("mm", 7);
    }

    @Test
    void testFeetConversion() {
        // given:
        final ConverterController controller = new ConverterController();

        // when:
        final ModelAndView result = controller.convert(11.0, 0.0);

        // then:
        assertThat(result.getModel()).containsEntry("cm", 335);
        assertThat(result.getModel()).containsEntry("mm", 3);
    }

    @Test
    void testFeetAndInchesConversion() {
        // given:
        final ConverterController controller = new ConverterController();

        // when:  91.44
        final ModelAndView result = controller.convert(3.0, 7.0);

        // then:
        assertThat(result.getModel()).containsEntry("cm", 109);
        assertThat(result.getModel()).containsEntry("mm", 2);
    }

    @Test
    void testFeetNullConversion() {
        // given:
        final ConverterController controller = new ConverterController();

        // when:
        final ModelAndView result = controller.convert(0.0, 5.0);

        // then:
        assertThat(result.getModel()).containsEntry("cm", 12);
        assertThat(result.getModel()).containsEntry("mm", 7);
    }

    @Test
    void testInchesNullConversion() {
        // given:
        final ConverterController controller = new ConverterController();

        // when:
        final ModelAndView result = controller.convert(11.0, 0.0);

        // then:
        assertThat(result.getModel()).containsEntry("cm", 335);
        assertThat(result.getModel()).containsEntry("mm", 3);
    }

}
