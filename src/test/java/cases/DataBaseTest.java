package cases;

import elements.mapper.AgentsMapper;
import elements.mapper.CustomerMapper;
import elements.mapper.OrdersMapper;
import elements.model.Agents;
import io.qameta.allure.Story;
import lombok.SneakyThrows;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import utils.TestResultLoggerExtension;

import java.io.Reader;
import java.math.BigDecimal;

import static configuration.PropertiesConfiguration.myBatisLocation;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@ExtendWith(TestResultLoggerExtension.class)
@DisplayName("My SQL data base check")
public class DataBaseTest {
    private static SqlSessionFactory factory = null;
    private static SqlSession session = null;

    private static AgentsMapper agentsMapper;
    private static CustomerMapper customerMapper;
    private static OrdersMapper ordersMapper;

    @SneakyThrows
    @BeforeEach
    public void setUp() {
        Reader reader = Resources.getResourceAsReader(myBatisLocation());
        factory = new SqlSessionFactoryBuilder().build(reader);
        session = factory.openSession();

        agentsMapper = session.getMapper(AgentsMapper.class);
        customerMapper = session.getMapper(CustomerMapper.class);
        ordersMapper = session.getMapper(OrdersMapper.class);
    }

    @AfterEach
    public void tearDown() {
        if (session != null) {
            session.close();
        }
    }

    @Test
    @Story("Check existing agent")
    @DisplayName("Check existing agent")
    public void testExistingAgent() {
        Agents expected = Agents.builder()
                .agentCode("A012")
                .agentName("Lucida")
                .workingArea("San Jose")
                .commission(BigDecimal.valueOf(0.12))
                .phoneNo("044-52981425")
                .country("")
                .build();

        Agents actual = agentsMapper.findAgentById("A012");
        assertThat(actual).isEqualTo(expected);
    }
}

