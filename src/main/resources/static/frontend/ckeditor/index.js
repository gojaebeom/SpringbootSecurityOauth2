export const ckEditor = () => {
    if(document.querySelector( '#editor' ) !== null)
        ClassicEditor
            .create( document.querySelector( '#editor' ) )
            .catch( error => {
                console.error( error );
            } );
    
    ClassicEditor.editorConfig = ( config ) => {
        // misc options
        config.height = '500px';
    };
}