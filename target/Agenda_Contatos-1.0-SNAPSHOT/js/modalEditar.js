function openModalEditar(nome, email, telefone,id) {
    //modal
    document.getElementById("modalEditar").style.opacity = "1"
    document.getElementById("modalEditar").style.pointerEvents = "all"
    //fade 2
    document.getElementById("fade2").style.opacity = '1'
    document.getElementById("fade2").style.pointerEvents = 'all'
    document.getElementById("inomeEditar").value = nome;
    document.getElementById("iemailEditar").value = email;
    document.getElementById("itelefoneEditar").value = telefone;
    document.getElementById("iidEditar").value = id;
    
}
function closeModalEditar() {
    //modal
    document.getElementById("modalEditar").style.opacity = "0"
    document.getElementById("modalEditar").style.pointerEvents = "none"
    //fade 2
    document.getElementById("fade2").style.opacity = '0'
    document.getElementById("fade2").style.pointerEvents = 'none'
}


