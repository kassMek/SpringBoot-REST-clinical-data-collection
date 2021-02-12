package clinical.com.clinicalrestfuldatacollection.dao;

import clinical.com.clinicalrestfuldatacollection.entity.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Integer> {
}
