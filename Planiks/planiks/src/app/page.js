import React from "react";
import FormEvento from "@/components/FormEvento";




export default  function TelaEvento () {
 
  return(
  <>
  <div>
      <h1 style={{
        display: 'flex',
        width: '487px',
        height: '72px',
        flexDirection: 'column',
        justifyContent: 'center',
        color: '#000',
        textAlign: 'center',
        fontFamily: 'Inter',
        fontSize: '64px',
        fontStyle: 'normal',
        fontWeight: 700,
        lineHeight: 'normal',
        textTransform: 'capitalize',
        
      }}>
        Event🔻
      </h1>
    </div>
  <FormEvento />
  </>
  

  )
} 