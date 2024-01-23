package br.com.neuroconexao.neuroconexaobackend.controllers;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.neuroconexao.neuroconexaobackend.models.Neurodiverso;
import br.com.neuroconexao.neuroconexaobackend.services.NeurodiversoService;

 
@RestController
@RequestMapping("/neurodiversos")
public class NeurodiversoController {
 
    @Autowired
    private NeurodiversoService ns;
 
    @PostMapping("/savenneurodiverso")
    public Neurodiverso createNeurodiverso(@RequestBody Neurodiverso neurodiverso) {
        return ns.saveNeurodiverso(neurodiverso);
    }
 
    @GetMapping("/allneurodiversos")
    public List<Neurodiverso> getAllNeurodiversos() {
        return ns.getAllNeurodiversos();
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<Neurodiverso> getNeurodiverso(@PathVariable Long id) {
        Neurodiverso neurodiverso = ns.getNeurodiversoById(id);
        return ResponseEntity.ok(neurodiverso);
    }
 
    @PutMapping("/{id}")
    public ResponseEntity<Neurodiverso> updateNeurodiverso(@PathVariable Long id, @RequestBody Neurodiverso updatedNeurodiverso) {
        Neurodiverso neurodiverso = ns.getNeurodiversoById(id);
 
        neurodiverso.setNeurodiversodivergencia(updatedNeurodiverso.getNeurodiversodivergencia());
        neurodiverso.setNome(updatedNeurodiverso.getNome());
        neurodiverso.setCpf(updatedNeurodiverso.getCpf());
        neurodiverso.setEmail(updatedNeurodiverso.getEmail());
        neurodiverso.setSenha(updatedNeurodiverso.getSenha());
        neurodiverso.setTelefone(updatedNeurodiverso.getTelefone());
        neurodiverso.setDatanascimento(updatedNeurodiverso.getDatanascimento());
        
        ns.updateNeurodiverso(id, updatedNeurodiverso);
        return ResponseEntity.ok(neurodiverso);
    }
 
    @DeleteMapping("/{id}")
    public void deleteNeurodiverso(@PathVariable Long id) {
        ns.deleteNeurodiverso(id);
    }
}

