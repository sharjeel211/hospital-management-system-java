package iqrahospital;

import Images.AppIcon;
import java.io.FileOutputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.sql.Connection;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author shada
 */
public class AppoinmentDetails extends javax.swing.JFrame {

    /**
     * Creates new form FirstScreen
     */
    public AppoinmentDetails() {
        initComponents();
        updateLabels();
        updateCard();

    }

    int mrNumber;

    public AppoinmentDetails(int mrNumber) {
        initComponents();
        this.mrNumber = mrNumber;
        updateLabels();
        AppIcon.setIcon(this);
        //sendEmail();
        updateCard();

    }
    int card;

    public void updateCard() {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/iqrahospital", "root", "");
            String selectStatement = "SELECT * FROM patientdata WHERE MrNumber = ?";
            PreparedStatement stmt = conn.prepareStatement(selectStatement);
            stmt.setInt(1, mrNumber);
            ResultSet result = stmt.executeQuery();

            // Check whether Appointment Number is found in DB
            if (result.next()) {
                card = result.getInt("RecordNumber");
                if (card == 0) {
                    viewCard.setText("");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Record not found!");
            }
            conn.close();
        } catch (Exception e) {
            // Log the exception for debugging purposes
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Something went wrong! Try again later");
        }
    }

    public void sendEmail() {
        // Recipient's email ID needs to be mentioned.
        String to = txtEmail;

        // Sender's email ID needs to be mentioned
        String from = "iqrahospital3@gmail.com";

        // Assuming you are sending email from through gmail smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587"); // Use port 587 instead of 465
        properties.put("mail.smtp.starttls.enable", "true"); // Use STARTTLS
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2"); // Set TLS protocol explicitly

        // Get the Session object and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("iqrahospital3@gmail.com", "jhxfigibfvevwule"); // Use your app password
            }
        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject(txtName + ", Your Appoinment has been Booked - #" + mrNumber);

            // Now set the actual message
            message.setText("Hi " + txtName + ",You're  appointment has been booked \nYou're Appointment No is : " + mrNumber + "\nDoctor : " + txtDoctor + "\nSpeciality: " + txtSpeciality + "\nTime: " + txtTimeSlot + "\nPayment Status: " + txtPayment);

            System.out.println("Sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
    String txtName;
    String txtSpeciality;
    String txtDoctor;
    String txtTimeSlot;
    String txtPayment;
    String txtEmail;

    private void updateLabels() {
        //System.out.println(mrNumber);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/iqrahospital", "root", "");

            // Retrieve the data using the unique ID
            String selectStatement = "SELECT * FROM patientdata WHERE mrNumber = ?";
            PreparedStatement stmt = conn.prepareStatement(selectStatement);
            stmt.setInt(1, mrNumber);
            ResultSet result = stmt.executeQuery();

            // Retrieve the first row of data
            if (result.next()) {
                txtName = result.getString("FirstName");
                txtSpeciality = result.getString("speciality");
                txtDoctor = result.getString("Doctor");
                txtTimeSlot = result.getString("timeSlot");
                txtPayment = result.getString("paymentStatus");
                txtEmail = result.getString("email");

                // Update the text of the labels
                LtxtName.setText("Hi " + txtName + ", Your Appointment has been booked!");
                LtxtMr.setText("Your Appoinment # is: " + mrNumber);
                LtxtSpeciality.setText("Speciality: " + txtSpeciality);
                LtxtDoctor.setText("Doctor: " + txtDoctor);
                LtxtTimeSlot.setText("Time Slot: " + txtTimeSlot);
                Lpayment.setText("Payment Status: " + txtPayment);

            }

            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e + "Something went wrong! Try again later");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnDownload = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        LtxtSpeciality = new javax.swing.JLabel();
        LtxtName = new javax.swing.JLabel();
        LtxtMr = new javax.swing.JLabel();
        LtxtTimeSlot = new javax.swing.JLabel();
        LtxtDoctor = new javax.swing.JLabel();
        Lpayment = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        viewCard = new javax.swing.JLabel();

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Doctor :Xyz ");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("IQRA HOSPITAL");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(18, 25, 67));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255), 6));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ScreensLogo.png"))); // NOI18N
        jLabel1.setAlignmentX(1.0F);
        jLabel1.setAlignmentY(1.0F);

        btnDownload.setBackground(new java.awt.Color(18, 25, 67));
        btnDownload.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        btnDownload.setForeground(new java.awt.Color(255, 255, 255));
        btnDownload.setText("Download ↓");
        btnDownload.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        btnDownload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDownloadActionPerformed(evt);
            }
        });

        back.setBackground(new java.awt.Color(18, 25, 67));
        back.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        back.setForeground(new java.awt.Color(255, 255, 255));
        back.setText("← Quit");
        back.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N

        LtxtSpeciality.setFont(new java.awt.Font("Palatino Linotype", 1, 17)); // NOI18N
        LtxtSpeciality.setForeground(new java.awt.Color(255, 255, 255));
        LtxtSpeciality.setText("Doctor :Xyz ");

        LtxtName.setFont(new java.awt.Font("Palatino Linotype", 1, 17)); // NOI18N
        LtxtName.setForeground(new java.awt.Color(255, 255, 255));
        LtxtName.setText("Hi, Name, You're  appointment has been booked");
        LtxtName.setToolTipText("");

        LtxtMr.setFont(new java.awt.Font("Palatino Linotype", 1, 17)); // NOI18N
        LtxtMr.setForeground(new java.awt.Color(255, 255, 255));
        LtxtMr.setText("You're Appointment No is : #123 ");

        LtxtTimeSlot.setFont(new java.awt.Font("Palatino Linotype", 1, 17)); // NOI18N
        LtxtTimeSlot.setForeground(new java.awt.Color(255, 255, 255));
        LtxtTimeSlot.setText("Time : m.. ");

        LtxtDoctor.setFont(new java.awt.Font("Palatino Linotype", 1, 17)); // NOI18N
        LtxtDoctor.setForeground(new java.awt.Color(255, 255, 255));
        LtxtDoctor.setText("Category :Xyz ");

        Lpayment.setFont(new java.awt.Font("Palatino Linotype", 1, 17)); // NOI18N
        Lpayment.setForeground(new java.awt.Color(255, 255, 255));
        Lpayment.setText("Payment Status :");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Version 1.0");

        viewCard.setForeground(new java.awt.Color(255, 255, 255));
        viewCard.setText("<html><u>VIEW CARD</u></html>");
        viewCard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewCardMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(531, 531, 531)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(btnDownload, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(viewCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(LtxtDoctor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LtxtSpeciality, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LtxtMr, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(LtxtName, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LtxtTimeSlot, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Lpayment, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(LtxtName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(LtxtMr, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LtxtSpeciality, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LtxtDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LtxtTimeSlot, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(Lpayment, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(viewCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDownload, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addComponent(jLabel7)))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnDownloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDownloadActionPerformed
        generateAndDownloadPDF();
    }//GEN-LAST:event_btnDownloadActionPerformed

    private void generateAndDownloadPDF() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/iqrahospital",
                    "root", "");

            // Retrieve the data using the unique ID
            String selectStatement = "SELECT * FROM patientdata WHERE mrNumber = ?";
            PreparedStatement stmt = conn.prepareStatement(selectStatement);
            stmt.setInt(1, mrNumber);
            ResultSet result = stmt.executeQuery();

            // Retrieve the first row of data
            if (result.next()) {
                String txtName = result.getString("FirstName");
                String txtSpeciality = result.getString("speciality");
                String txtDoctor = result.getString("Doctor");
                String txtTimeSlot = result.getString("timeSlot");
                String txtPayment = result.getString("paymentStatus");

                // Create a new instance of a PDF document
                Document document = new Document();

                // Create a PDF writer, associating it with the document and specifying the output file
                PdfWriter.getInstance(document, new FileOutputStream("patientdata.pdf"));

                // Open the document, allowing for adding content to it
                document.open();

                // Add data from the database to the PDF document
                document.add(new Paragraph("WELCOME TO IQRA HOSPITAL"));
                document.add(new Paragraph("Hi " + txtName + ", Your Appointment has been booked!"));
                document.add(new Paragraph("Your Appointment # is: " + mrNumber));
                document.add(new Paragraph("Speciality: " + txtSpeciality));
                document.add(new Paragraph("Doctor: " + txtDoctor));
                document.add(new Paragraph("Time Slot: " + txtTimeSlot));
                document.add(new Paragraph("Payment Status: " + txtPayment));

                document.close();

                JOptionPane.showMessageDialog(this, "PDF generated and downloaded successfully!");
            }

            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e + " Something went wrong! Try again later");
        }
    }


    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        System.exit(0);
    }//GEN-LAST:event_backActionPerformed

    private void viewCardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewCardMouseClicked
        //logic here
        PatientCard pc = new PatientCard(mrNumber);
        pc.setVisible(true);
        
    }//GEN-LAST:event_viewCardMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FirstScreen.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FirstScreen.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FirstScreen.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FirstScreen.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FirstScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Lpayment;
    private javax.swing.JLabel LtxtDoctor;
    private javax.swing.JLabel LtxtMr;
    private javax.swing.JLabel LtxtName;
    private javax.swing.JLabel LtxtSpeciality;
    private javax.swing.JLabel LtxtTimeSlot;
    private javax.swing.JButton back;
    private javax.swing.JButton btnDownload;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel viewCard;
    // End of variables declaration//GEN-END:variables
}
