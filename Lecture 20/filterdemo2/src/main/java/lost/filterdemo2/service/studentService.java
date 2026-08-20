package lost.filterdemo2.service;


import lost.filterdemo2.Dto.StudentDto;
import org.springframework.stereotype.Service;

@Service
public class studentService {

    public void createStudent(StudentDto studentDto){
        System.out.println("student created ");
        System.out.println(studentDto.getName());
        System.out.println(studentDto.getEmail());
    }
}
