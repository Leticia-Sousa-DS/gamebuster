
import org.example.gamebusters.data.PlanEntity
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name= "gamers")
class GamerEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    val name: String = "name",
    val email: String = "email@email.com",
    val dateOfBirth: String?=null,
    val user: String?=null,
    @ManyToOne
    val plan: PlanEntity = PlanEntity.StandalonePlanEntity()
) {

}