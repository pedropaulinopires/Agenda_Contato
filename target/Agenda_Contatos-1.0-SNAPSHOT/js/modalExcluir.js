function openModalExcluir(id){
    document.getElementById('modalExcluir').style.opacity = '1';
    document.getElementById('modalExcluir').style.pointerEvents = 'all';
    document.getElementById('fade4').style.opacity = '1';
    document.getElementById('fade4').style.pointerEvents = 'all';
    document.getElementById('iidExcluir').value = id;
}

function closeModalExcluir(){
    document.getElementById('modalExcluir').style.opacity = '0';
    document.getElementById('modalExcluir').style.pointerEvents = 'none';
    document.getElementById('fade4').style.opacity = '0';
    document.getElementById('fade4').style.pointerEvents = 'none';
}
