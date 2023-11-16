import React from 'react'

export const hour = () => {

    const [time, setTime] = React.useState(null)

    React.useEffect(() => {
        // Atualizar a hora a cada segundo
        const intervalId = setInterval(updateDisplayHour, 1000);

        // Limpar o intervalo quando o componente for desmontado
        return () => clearInterval(intervalId);
    }, [])    

    function updateDisplayHour() {
        const currentDate = new Date();
        const currentHour = currentDate.getHours().toString().padStart(2, '0');
        const currentMinute = currentDate.getMinutes().toString().padStart(2, '0');
        const currentSecond = currentDate.getSeconds().toString().padStart(2, '0');
      
        setTime(`${currentHour}:${currentMinute}:${currentSecond}`);
    }    

    return time;
}

export default {
    hour,
}