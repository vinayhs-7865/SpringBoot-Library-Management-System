package com.example.lms.controller;

import com.example.lms.dto.AddRecordDTO;
import com.example.lms.model.Book;
import com.example.lms.model.Librarian;
import com.example.lms.model.Record;
import com.example.lms.model.Student;
import com.example.lms.service.BookService;
import com.example.lms.service.LibrarianService;
import com.example.lms.service.RecordService;
import com.example.lms.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@org.springframework.stereotype.Controller
@RequiredArgsConstructor
public class RecordController {
    private final BookService bookService;
    private final LibrarianService librarianService;
    private final StudentService studentService;
    private final RecordService recordService;

    @GetMapping("/addRecordPage")
    public String addRecordPage(Model model){
        model.addAttribute("books",bookService.displayAllBooks());
        model.addAttribute("librarians",librarianService.displayAllLibrarians());
        model.addAttribute("students",studentService.displayAllStudents());
        return "HTMLpages/records";
    }

    @PostMapping("/submitRecord")
    public String submitRecord(@ModelAttribute AddRecordDTO dto, Model model){
        try {
            // Validate input
            if (dto.getBookId() == null || dto.getLibrarianId() == null || dto.getStudentId() == null) {
                model.addAttribute("errorMessage", "Please select all required fields.");
                model.addAttribute("books", bookService.displayAllBooks());
                model.addAttribute("librarians", librarianService.displayAllLibrarians());
                model.addAttribute("students", studentService.displayAllStudents());
                return "HTMLpages/records";
            }

            Book book = bookService.findById(dto.getBookId());
            Librarian librarian = librarianService.findById(dto.getLibrarianId());
            Student student = studentService.findById(dto.getStudentId());

            if (book == null || librarian == null || student == null) {
                model.addAttribute("errorMessage", "Invalid selection. Please try again.");
                model.addAttribute("books", bookService.displayAllBooks());
                model.addAttribute("librarians", librarianService.displayAllLibrarians());
                model.addAttribute("students", studentService.displayAllStudents());
                return "HTMLpages/records";
            }

            Record record = Record.builder()
                .book(book)
                .librarian(librarian)
                .student(student)
                .build();

            recordService.addRecord(record);
            return "redirect:/records";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Error creating record: " + e.getMessage());
            model.addAttribute("books", bookService.displayAllBooks());
            model.addAttribute("librarians", librarianService.displayAllLibrarians());
            model.addAttribute("students", studentService.displayAllStudents());
            return "HTMLpages/records";
        }
    }

    @GetMapping("/records")
    public String displayAllRecords(Model model){
        try {
            model.addAttribute("books",bookService.displayAllBooks());
            model.addAttribute("librarians",librarianService.displayAllLibrarians());
            model.addAttribute("students",studentService.displayAllStudents());
            Iterable<Record> record = recordService.displayAllRecords();
            model.addAttribute("records",record);
            return "HTMLpages/records";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Error loading records: " + e.getMessage());
            return "HTMLpages/records";
        }
    }
}
