function conversione(giglo) {
    if(giglo === 0) {
        return ""
    } else {
        let barilla = giglo%2
        return conversione((giglo-barilla)/2) + barilla
    }
}
//barilla è il resto