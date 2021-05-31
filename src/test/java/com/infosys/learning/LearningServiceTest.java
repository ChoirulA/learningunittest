package com.infosys.learning;

import com.infosys.learning.data.Biodata;
import com.infosys.learning.data.Data;
import com.infosys.learning.data.Respond;
import com.infosys.learning.dto.UserRequest;
import com.infosys.learning.model.User;
import com.infosys.learning.repository.UserRepository;
import com.infosys.learning.service.LearningService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.anyString;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LearningServiceTest {

    @Autowired private LearningService learningService;

    @MockBean
    @Autowired private UserRepository userRepository;

    @Before
    public void init(){
        Mockito.when(userRepository.findByUserName(anyString())).thenReturn(new User());
        Mockito.when(userRepository.findByUserNameAndPassWord(anyString(), anyString())).thenReturn(new User());
    }

    @Test
    public void getName_shouldSuccess(){
        Assert.assertEquals("John", learningService.getName("man"));
    }

    @Test
    public void getName_shouldNotSuccess(){
        Assert.assertEquals("John", learningService.getName("female"));
    }

    @Test
    public void getNameV2_shouldSuccess(){
        Assert.assertEquals("John Walker", learningService.getNameV2("man").getName());
    }

    @Test
    public void getNameV2_shouldNotSuccess(){
        Assert.assertEquals("John Walker", learningService.getNameV2("female").getName());
    }

    @Test
    public void getNameV3_shouldSuccess(){
        Assert.assertEquals("John Doe", learningService.getNameV3("John"));
    }

    @Test
    public void getNameV3_shouldNotSuccess(){
        Assert.assertEquals("John Doe", learningService.getNameV3("Jane"));
    }

    @Test
    public void getCity_shouldSuccess(){
        Assert.assertEquals("Yogyakarta", learningService.getCity("Bantul"));
    }

    @Test
    public void getCity_shouldNotSuccess(){
        Assert.assertEquals("Yogyakarta", learningService.getCity("Sleman"));
    }

    @Test
    public void getCityV2_shouldSuccess(){
        Assert.assertEquals("Yogyakarta", learningService.getCityV2("Bantul").getCity());
    }

    @Test
    public void getCityV2_shouldNotSuccess(){
        Assert.assertEquals("Yogyakarta", learningService.getCityV2("Sleman").getCity());
    }

    @Test
    public void getCityV3_shouldSuccess(){
        Assert.assertEquals("Perum Graha Sedayu Sejahtera", learningService.getCityV3("Bantul"));
    }

    @Test
    public void getCityV3_shouldNotSuccess(){
        Assert.assertEquals("Perum Graha Sedayu Sejahtera", learningService.getCityV3("Sleman"));
    }

    @Test
    public void getPerson_shouldSuccess(){
        Assert.assertNotNull(learningService.getPerson("Cho", 1998));
    }

    @Test
    public void getPerson_shouldNotSuccess(){
        Biodata biodata = new Biodata();
        biodata.setName("Choi");
        Data data = new Data();
        data.setAge(24);
        Respond respond = new Respond();
        respond.setData(data);
        Assert.assertEquals(respond.getData().getAge(), learningService.getPerson("Cho", 1998).getData().getAge());
    }

    @Test
    public void register_shouldSuccess(){
        UserRequest userRequest = new UserRequest();
        userRequest.setUsername("Cho");
        userRequest.setPassword("Cho123");
        Assert.assertEquals("Register Success!", learningService.register(userRequest));
    }

    @Test
    public void login_shouldSuccess(){
        UserRequest userRequest = new UserRequest();
        userRequest.setUsername("jony");
        userRequest.setPassword("jony123");
        Assert.assertNotNull(learningService.login(userRequest));
    }
}
