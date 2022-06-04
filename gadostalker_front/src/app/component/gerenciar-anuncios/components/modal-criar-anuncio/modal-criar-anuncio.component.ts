import { Component, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatIconRegistry } from '@angular/material/icon';
import { DomSanitizer } from '@angular/platform-browser';

const ANEXO_ICON =
  `
  <svg style="width:24px;height:24px" viewBox="0 0 24 24">
    <path fill="currentColor" d="M16.5,6V17.5A4,4 0 0,1 12.5,21.5A4,4 0 0,1 8.5,17.5V5A2.5,2.5 0 0,1 11,2.5A2.5,2.5 0 0,1 13.5,5V15.5A1,1 0 0,1 12.5,16.5A1,1 0 0,1 11.5,15.5V6H10V15.5A2.5,2.5 0 0,0 12.5,18A2.5,2.5 0 0,0 15,15.5V5A4,4 0 0,0 11,1A4,4 0 0,0 7,5V17.5A5.5,5.5 0 0,0 12.5,23A5.5,5.5 0 0,0 18,17.5V6H16.5Z" />
  </svg>
`;
@Component({
  selector: 'app-modal-criar-anuncio',
  templateUrl: './modal-criar-anuncio.component.html',
  styleUrls: ['./modal-criar-anuncio.component.scss']
})
export class ModalCriarAnuncioComponent implements OnInit {
  constructor(
    public dialogRef: MatDialogRef<ModalCriarAnuncioComponent>,
    iconRegistry: MatIconRegistry,
    sanitizer: DomSanitizer,) {
    iconRegistry.addSvgIconLiteral('anexo', sanitizer.bypassSecurityTrustHtml(ANEXO_ICON));
  }
  file?: File;
  localUrl = '../../../assets/upload.png'
  ngOnInit(): void {
  }

  selectFile(event: any) {
    this.file = <File>event.target.files[0];
    if (event.target.files && event.target.files[0]) {
      var reader = new FileReader();
      reader.onload = (event: any) => {
        this.localUrl = event.target.result;
      }
      reader.readAsDataURL(event.target.files[0]);
    }
  }

  closeModal(): void {
    this.dialogRef.close();
  }
}
