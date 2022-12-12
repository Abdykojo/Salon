package kg.m.salon.repositories;

import kg.m.salon.models.entity.Master;
import kg.m.salon.models.entity.WorkDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface WorkDayRep extends JpaRepository<WorkDay,Long> {
    @Modifying
    @Transactional
    @Query(value = "insert into tb_work_day_master(work_day_id,master_id) VALUES(?1,?2)",nativeQuery = true)
    int create(Long workDayId,Long masterId);
    @Query(value = "select * from tb_work_day_master JOIN tb_work_day ON tb_work_day.id = tb_work_day_master.work_day_id where master_id=?1",nativeQuery = true)
    List<WorkDay> findbyMaster(Long masterId);
}
