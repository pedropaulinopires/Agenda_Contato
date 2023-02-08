function openModalLimpar(){
    document.getElementById('modalLimpar').style.opacity = '1';
    document.getElementById('modalLimpar').style.pointerEvents = 'all';
    document.getElementById('fade3').style.opacity = '1';
    document.getElementById('fade3').style.pointerEvents = 'all';
}

function closeModalLimpar(){
    document.getElementById('modalLimpar').style.opacity = '0';
    document.getElementById('modalLimpar').style.pointerEvents = 'none';
    document.getElementById('fade3').style.opacity = '0';
    document.getElementById('fade3').style.pointerEvents = 'none';
}