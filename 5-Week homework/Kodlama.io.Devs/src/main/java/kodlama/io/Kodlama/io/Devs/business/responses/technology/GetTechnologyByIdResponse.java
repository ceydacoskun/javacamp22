package kodlama.io.Kodlama.io.Devs.business.responses.technology;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetTechnologyByIdResponse {
   private int id;
   private String name;
   private String language;
   
} 
