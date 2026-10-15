package in.coderarmy.hibernateDemo.model;

import jakarta.persistence.AttributeConverter;
import org.hibernate.metamodel.model.domain.internal.AttributeContainer;

public class BooleanToStringConverter
        implements AttributeConverter<Boolean,String>{

    @Override
    public String convertToDatabaseColumn(Boolean attribute) {
        if(attribute==null) return null;
        if(attribute==true){
            return "yes";
        }
        else{
            return "no";
        }
    }

    @Override
    public Boolean convertToEntityAttribute(String dbData) {
        if(dbData==null) return null;
        if(dbData.equals("yes")){
            return true;
        }
        return false;
    }
}
