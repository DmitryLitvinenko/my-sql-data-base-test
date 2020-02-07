package elements.mapper;

import elements.model.Agents;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface AgentsMapper {
       @Select("SELECT * FROM AGENTS WHERE AGENT_CODE = #{id}")
    @Results({
                     @Result(property = "agentCode", column = "agent_code"),
                     @Result(property = "agentName", column = "agent_name"),
                     @Result(property = "workingArea", column = "working_area"),
                     @Result(property = "phoneNo", column = "phone_no"),
             })
    Agents findAgentById(String id);

}
