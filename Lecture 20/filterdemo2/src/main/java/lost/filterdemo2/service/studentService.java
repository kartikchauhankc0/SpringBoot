package lost.filterdemo2.service;


import lost.filterdemo2.Dto.StudentDto;
import lost.filterdemo2.Dto.StudentResponseDto;
import org.springframework.stereotype.Service;

@Service
public class studentService {

    public StudentResponseDto createStudent(StudentDto studentDto){
        StudentResponseDto responseDto=
                new StudentResponseDto();

        responseDto.setName(studentDto.getName());
        responseDto.setMessage("Student is saved succesfully");

        return responseDto;

    }
}
