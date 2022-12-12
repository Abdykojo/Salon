package kg.m.salon.repositories;

import kg.m.salon.models.entity.Master;
import kg.m.salon.models.entity.Salon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface MasterRep extends JpaRepository<Master,Long> {
    @Query("select m from Master m where m.salonId.id=:salonId")
    List<Master>findbySalon(Long salonId);
}
