package ru.aplana.autotests.element;

import com.aplana.chameleon.definitions.repository.DefaultElementFacadeMapper;
import com.aplana.chameleon.definitions.repository.selenium.elements.MetaButton;
import com.aplana.chameleon.definitions.repository.selenium.elements.MetaComboBox;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Здесь прописывается соответстве метаклассов (держат данные, прочитанные из XML)
 * и поведенческих классов (отвечающих за взаимодействие с интерфейсом).
 * Настраиваются новые метаклассы, отсутсвующие в хамелеоне. А такжеJSTextInput
 * переопределются поведенческие классы для существующих метаклассов (если требуетя кастомная реализация).
 */
@Component
@Primary
public class ElementFacadeMapper extends DefaultElementFacadeMapper {

	private static final Class[][] CLASS_PAIRS = {
		{MetaButton.class, Button.class},
		{MetaComboBox.class, ComboBox.class}


	};

	@Override
	public String getFacadeClassName(Class aClass) {
		return Arrays.stream(CLASS_PAIRS)
			.filter((clazzPair) -> clazzPair[0] == aClass)
			.map((clazzPair) -> clazzPair[1].getPackage().getName() + "." + clazzPair[1].getSimpleName())
			.findFirst()
			.orElse(super.getFacadeClassName(aClass));
        /*
        if (MetaComboBox.class == aClass){
            return ComboBox.class.getPackage().getProfile() + "." + ComboBox.class.getSimpleName();
        }
        if (MetaTextInput.class == aClass){
            return TextInput.class.getPackage().getProfile() + "." + TextInput.class.getSimpleName();
        }
        if (MetaStaticText.class == aClass){
            return StaticText.class.getPackage().getProfile() + "." + StaticText.class.getSimpleName();
        }
        if (MetaImg.class == aClass){
            return Img.class.getPackage().getProfile() + "." + Img.class.getSimpleName();
        }
        if (MetaFieldPrintTable.class == aClass){
            return FieldPrintTable.class.getPackage().getProfile() + "." + FieldPrintTable.class.getSimpleName();
        }
        if (MetaRadioButton.class == aClass){
            return RadioGroup.class.getPackage().getProfile() + "." + RadioGroup.class.getSimpleName();
        }
        return super.getFacadeClassName(aClass);
        */
	}
}
