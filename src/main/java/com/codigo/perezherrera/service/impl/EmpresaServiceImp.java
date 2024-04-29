package com.codigo.perezherrera.service.impl;

import com.codigo.perezherrera.dao.EmpresaRepository;
import com.codigo.perezherrera.entity.EmpresaEntity;
import com.codigo.perezherrera.service.EmpresaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmpresaServiceImp implements EmpresaService {

    private final EmpresaRepository empresaRepository;

    @Override
    public EmpresaEntity crear(EmpresaEntity empresaEntity) {
        empresaEntity.setEstado(1);
        empresaEntity.setUsuarioCreacion("Admin");
        empresaEntity.setFechaCreacion(getTimestamp());
        return empresaRepository.save(empresaEntity) ;
    }

    private Timestamp getTimestamp(){
        long currenTIme = System.currentTimeMillis();
        return new Timestamp(currenTIme);
    }

    @Override
    public Optional<EmpresaEntity> buscarPorId(Long id) {

            return empresaRepository.findById(id);

    }

    @Override
    public List<EmpresaEntity> buscarTodos() {
        return empresaRepository.findAll();
    }

    @Override
    public EmpresaEntity actualizar(Long id, EmpresaEntity empresaEntity) {

        Optional<EmpresaEntity> empresaRecuperada = empresaRepository.findById(id);
        if(empresaRecuperada.isPresent()){
            EmpresaEntity empresa = empresaRecuperada.get();
            empresa.setRazonSocial(empresaEntity.getRazonSocial());
            empresa.setTipoDocumento(empresaEntity.getTipoDocumento());
            empresa.setNumeroDocumento(empresaEntity.getNumeroDocumento());
            empresa.setCondicion(empresaEntity.getCondicion());
            empresa.setDireccion(empresaEntity.getDistrito());
            empresa.setDistrito(empresaEntity.getDistrito());
            empresa.setProvincia(empresaEntity.getProvincia());
            empresa.setDepartamento(empresaEntity.getDepartamento());
            empresa.setEsAgenteRetencion(empresaEntity.getEsAgenteRetencion());
            empresa.setUsuarioModificacion("Admin");
            empresa.setFechaModificacion(getTimestamp());
            return empresaRepository.save(empresa);

        }
        return null;
    }

    @Override
    public EmpresaEntity borrar(Long id) {

        Optional<EmpresaEntity> empresaRecuperada = empresaRepository.findById(id);
        if(empresaRecuperada.isPresent()){
            empresaRecuperada.get().setEstado(0);
            empresaRecuperada.get().setUsuarioEliminacion("Admin");
            empresaRecuperada.get().setFechaEliminacion(getTimestamp());
            return empresaRepository.save(empresaRecuperada.get());

        }
        return null;
    }

}
