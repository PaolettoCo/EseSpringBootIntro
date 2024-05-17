package TestExcercise.TestExcercise.student;

import TestExcercise.TestExcercise.student.dto.Mapper;
import TestExcercise.TestExcercise.student.dto.StudentDto;
import TestExcercise.TestExcercise.student.dto.StudentListDto;
import TestExcercise.TestExcercise.student.repo.Repository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class StudentTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private Repository repository;
    @Autowired
    private Mapper mapper;


    @Test
    public void postTest() throws Exception {
        repository.deleteAll();

        StudentDto studentDto = StudentDto.StudentDtoBuilder.aStudentDto()
                .withName("pippo")
                .withSurname("pippolo")
                .withIsWorking(true)
                .build();

        MockHttpServletResponse response = mockMvc.perform(post("/student/save")
               .content(objectMapper.writeValueAsString(studentDto))
               .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();
        Student check = objectMapper.readValue(response.getContentAsString(), Student.class);

        assertEquals(200, response.getStatus());
        assertEquals(check.getName(), "pippo");
    }

    @Test
    public void getAllTest() throws Exception {
        repository.deleteAll();

        StudentDto studentDto = StudentDto.StudentDtoBuilder.aStudentDto()
                .withName("pippo")
                .withSurname("pippolo")
                .withIsWorking(true)
                .build();

        mockMvc.perform(post("/student/save")
                .content(objectMapper.writeValueAsString(studentDto))
                .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        MockHttpServletResponse response = mockMvc.perform(get("/student")).andReturn().getResponse();

        StudentListDto check = objectMapper.readValue(response.getContentAsString(), StudentListDto.class);
        assertFalse(check.getStudents().isEmpty());
    }

    @Test
    public void getById() throws Exception {
        repository.deleteAll();

        StudentDto studentDto = StudentDto.StudentDtoBuilder.aStudentDto()
                .withName("pippo")
                .withSurname("pippolo")
                .withIsWorking(true)
                .build();

        MockHttpServletResponse responsePost = mockMvc.perform(post("/student/save")
                .content(objectMapper.writeValueAsString(studentDto))
                .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        Long id = objectMapper.readValue(responsePost.getContentAsString(), Student.class).getId();

        MockHttpServletResponse response = mockMvc.perform(get("/student/{id}", id)).andReturn().getResponse();

        Student check = objectMapper.readValue(response.getContentAsString(), Student.class);

        assertEquals(check.getName(), "pippo");
    }

    @Test
    public void update() throws Exception{
        repository.deleteAll();

        StudentDto studentDto = StudentDto.StudentDtoBuilder.aStudentDto()
                .withName("pippo")
                .withSurname("pippolo")
                .withIsWorking(true)
                .build();

        MockHttpServletResponse responsePost = mockMvc.perform(post("/student/save")
                .content(objectMapper.writeValueAsString(studentDto))
                .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        Student student = objectMapper.readValue(responsePost.getContentAsString(), Student.class);
        student.setName("giggio");

        MockHttpServletResponse responseUpdate = mockMvc.perform(put("/student/update")
                .content(objectMapper.writeValueAsString(student))
                .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        Student checkUpdate = objectMapper.readValue(responseUpdate.getContentAsString(), Student.class);

        assertEquals(checkUpdate.getName(), "giggio");

        Long id = checkUpdate.getId();
        MockHttpServletResponse responseUpdateIsWorking = mockMvc.perform(put("/student/{id}", id)
                .param("isWorking", "false")).andReturn().getResponse();

        Student checkUpdateIsWorking  = objectMapper.readValue(responseUpdateIsWorking.getContentAsString(), Student.class);

        assertFalse(checkUpdateIsWorking.getIsWorking());
    }

    @Test void deleteStudent() throws Exception{
        repository.deleteAll();

        StudentDto studentDto = StudentDto.StudentDtoBuilder.aStudentDto()
                .withName("pippo")
                .withSurname("pippolo")
                .withIsWorking(true)
                .build();

        MockHttpServletResponse responsePost = mockMvc.perform(post("/student/save")
                .content(objectMapper.writeValueAsString(studentDto))
                .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        Student student = objectMapper.readValue(responsePost.getContentAsString(), Student.class);

        Long id = student.getId();

        MockHttpServletResponse response = mockMvc.perform(delete("/student/{id}", id)).andReturn().getResponse();

        Optional<Student> studentByID = repository.findById(id);

        assertEquals(200, response.getStatus());
        assertTrue(studentByID.isEmpty());
    }
}
