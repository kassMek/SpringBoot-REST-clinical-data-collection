package clinical.com.clinicalrestfuldatacollection.dao;

import clinical.com.clinicalrestfuldatacollection.entity.ClinicalData;
import org.springframework.data.repository.CrudRepository;

public interface ClinicalDataRepository  extends CrudRepository<ClinicalData,Integer> {
}
